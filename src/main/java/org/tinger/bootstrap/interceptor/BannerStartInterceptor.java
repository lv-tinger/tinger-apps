package org.tinger.bootstrap.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.tinger.core.apps.ApplicationEventType;

/**
 * Created by tinger on 2022-10-04
 */
@Slf4j
public class BannerStartInterceptor extends BannerInterceptor {


    @Override
    public ApplicationEventType getEventType() {
        return ApplicationEventType.START;
    }

    @Override
    protected String getPreBanner() {
        return "classpath://banner/pre_start.banner.txt";
    }

    @Override
    protected String getSufBanner() {
        return "classpath://banner/suf_start.banner.txt";
    }
}
