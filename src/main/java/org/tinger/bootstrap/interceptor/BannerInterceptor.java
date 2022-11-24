package org.tinger.bootstrap.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.tinger.common.utils.ResourceUtils;
import org.tinger.common.utils.StringUtils;
import org.tinger.core.apps.Application;
import org.tinger.core.apps.ApplicationInterceptor;

/**
 * Created by tinger on 2022-10-04
 */
@Slf4j
public abstract class BannerInterceptor implements ApplicationInterceptor {

    protected abstract String getPreBanner();

    protected abstract String getSufBanner();

    @Override
    public void preHandler(Application application) {
        String text = ResourceUtils.readText(getPreBanner());
        if (StringUtils.isNotEmpty(text)) {
            log.info("\n" + text);
        }
    }

    @Override
    public void sufHandler(Application application) {
        String text = ResourceUtils.readText(getSufBanner());
        if (StringUtils.isNotEmpty(text)) {
            log.info("\n" + text);
        }
    }
}
