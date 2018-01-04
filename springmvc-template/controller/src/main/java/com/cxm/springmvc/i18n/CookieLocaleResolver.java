package com.cxm.springmvc.i18n;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.context.i18n.TimeZoneAwareLocaleContext;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by yuhang.xu on 2016/8/25.
 */
public class CookieLocaleResolver extends CookieGenerator implements LocaleContextResolver {

    public static final String LOCALE_REQUEST_ATTRIBUTE_NAME = org.springframework.web.servlet.i18n.CookieLocaleResolver.class.getName() + ".LOCALE";
    public static final String TIME_ZONE_REQUEST_ATTRIBUTE_NAME = org.springframework.web.servlet.i18n.CookieLocaleResolver.class.getName() + ".TIME_ZONE";
    public static final String DEFAULT_COOKIE_NAME = org.springframework.web.servlet.i18n.CookieLocaleResolver.class.getName() + ".LOCALE";
    private Locale defaultLocale;
    private TimeZone defaultTimeZone;

    public CookieLocaleResolver() {
        this.setCookieName(DEFAULT_COOKIE_NAME);
    }

    protected Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    protected TimeZone getDefaultTimeZone() {
        return this.defaultTimeZone;
    }

    public void setDefaultTimeZone(TimeZone defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }

    public Locale resolveLocale(HttpServletRequest request) {
        this.parseLocaleCookieIfNecessary(request);
        return (Locale) request.getAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME);
    }

    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        this.setLocaleContext(request, response, locale != null ? new SimpleLocaleContext(locale) : null);
    }

    public LocaleContext resolveLocaleContext(final HttpServletRequest request) {
        this.parseLocaleCookieIfNecessary(request);
        return new TimeZoneAwareLocaleContext() {
            public Locale getLocale() {
                return (Locale) request.getAttribute(org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME);
            }

            public TimeZone getTimeZone() {
                return (TimeZone) request.getAttribute(org.springframework.web.servlet.i18n.CookieLocaleResolver.TIME_ZONE_REQUEST_ATTRIBUTE_NAME);
            }
        };
    }

    public void setLocaleContext(HttpServletRequest request, HttpServletResponse response, LocaleContext localeContext) {
        Locale locale = null;
        TimeZone timeZone = null;
        if (localeContext != null) {
            locale = localeContext.getLocale();
            if (localeContext instanceof TimeZoneAwareLocaleContext) {
                timeZone = ((TimeZoneAwareLocaleContext) localeContext).getTimeZone();
            }

            this.addCookie(response, (locale != null ? locale : "-") + (timeZone != null ? ' ' + timeZone.getID() : ""));
        } else {
            this.removeCookie(response);
        }

        request.setAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME, locale != null ? locale : this.determineDefaultLocale(request));
        request.setAttribute(TIME_ZONE_REQUEST_ATTRIBUTE_NAME, timeZone != null ? timeZone : this.determineDefaultTimeZone(request));
    }

    private void parseLocaleCookieIfNecessary(HttpServletRequest request) {
        if (request.getAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME) == null) {
            Cookie cookie = WebUtils.getCookie(request, this.getCookieName());
            Locale locale = null;
            TimeZone timeZone = null;
            if (cookie != null) {
                String value = cookie.getValue();
                String localePart = value;
                String timeZonePart = null;
                int spaceIndex = value.indexOf(32);
                if (spaceIndex != -1) {
                    localePart = value.substring(0, spaceIndex);
                    timeZonePart = value.substring(spaceIndex + 1);
                }

                locale = !"-".equals(localePart) ? RequestUtils.parseLocaleString(localePart) : null;
                if (timeZonePart != null) {
                    timeZone = StringUtils.parseTimeZoneString(timeZonePart);
                }

                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Parsed cookie value [" + cookie.getValue() + "] into locale \'" + locale + "\'" + (timeZone != null ? " and time zone \'" + timeZone.getID() + "\'" : ""));
                }
            }

            request.setAttribute(LOCALE_REQUEST_ATTRIBUTE_NAME, locale != null ? locale : this.determineDefaultLocale(request));
            request.setAttribute(TIME_ZONE_REQUEST_ATTRIBUTE_NAME, timeZone != null ? timeZone : this.determineDefaultTimeZone(request));
        }

    }

    protected Locale determineDefaultLocale(HttpServletRequest request) {
        Locale defaultLocale = this.getDefaultLocale();
        if (defaultLocale == null) {
            defaultLocale = request.getLocale();
        }

        return defaultLocale;
    }

    protected TimeZone determineDefaultTimeZone(HttpServletRequest request) {
        return this.getDefaultTimeZone();
    }
}
