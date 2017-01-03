package com.thermatk.android.xf.xperiafmwohs;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XC_MethodReplacement;

public class XperiaFMwoHS implements IXposedHookLoadPackage {
	public void handleLoadPackage(final LoadPackageParam lpparam)
			throws Throwable {
		if (!lpparam.packageName.equals("com.android.fmradio"))
			return;

		XposedBridge.log("inside FMRadio!");

		findAndHookMethod("com.android.fmradio.FmMainActivity",
				lpparam.classLoader, "isAntennaAvailable", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return true;
                    }
                });

		findAndHookMethod("com.android.fmradio.FmService",
				lpparam.classLoader, "isAntennaAvailable", new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return true;
                    }
                });
	}
}
