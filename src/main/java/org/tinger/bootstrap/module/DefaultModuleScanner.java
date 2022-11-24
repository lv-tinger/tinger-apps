package org.tinger.bootstrap.module;

import org.tinger.common.utils.ClassUtils;
import org.tinger.common.utils.ResourceUtils;
import org.tinger.common.utils.ServiceLoaderUtils;
import org.tinger.core.apps.Module;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tinger on 2022-10-03
 */
public class DefaultModuleScanner implements ModuleScanner {
    private static final String file = "classpath://org.tinger.module.ini";

    @Override
    public List<Module> scan() {
        List<String> moduleNames = ResourceUtils.readLines(file);
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        if (classLoader == null) {
            throw new RuntimeException();
        }
        List<Module> modules = new LinkedList<>();
        try {
            for (String moduleName : moduleNames) {
                Class<?> moduleClass = classLoader.loadClass(moduleName);
                if (!moduleClass.isInterface() || !Module.class.isAssignableFrom(moduleClass)) {
                    throw new RuntimeException();
                }
                ServiceLoaderUtils.load(moduleClass);
                Module module = (Module) ServiceLoaderUtils.load(moduleClass);
                modules.add(module);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return modules;
    }
}
