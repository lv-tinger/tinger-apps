package org.tinger.bootstrap.interceptor;

import org.tinger.core.apps.ApplicationEventType;

/**
 * Created by tinger on 2022-10-04
 */
public class BannerCloseInterceptor extends BannerInterceptor {

    @Override
    public ApplicationEventType getEventType() {
        return ApplicationEventType.CLOSE;
    }

    @Override
    protected String getPreBanner() {
        return "classpath://banner/pre_close.banner.txt";
    }

    @Override
    protected String getSufBanner() {
        return "classpath://banner/suf_close.banner.txt";
    }
}