package org.tinger.bootstrap.module;

import org.tinger.core.apps.Module;

import java.util.List;

/**
 * Created by tinger on 2022-10-03
 */
public interface ModuleScanner {
    List<Module<?>> scan();
}