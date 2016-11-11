// Copyright 2015-present 650 Industries. All rights reserved.

package host.exp.exponent.kernel;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;

import javax.inject.Inject;

import host.exp.exponent.analytics.EXL;
import host.exp.exponent.di.NativeModuleDepsProvider;
import host.exp.exponentview.Exponent;

public class ExponentViewKernel implements KernelInterface {

  private static final String TAG = ExponentViewKernel.class.getSimpleName();

  private static ExponentViewKernel sInstance;
  private static String sVersionName;

  @Inject
  Context mContext;

  @Inject
  Application mApplicationContext;

  public static ExponentViewKernel getInstance() {
    if (sInstance == null) {
      sInstance = new ExponentViewKernel();
    }

    return sInstance;
  }

  private ExponentViewKernel() {
    NativeModuleDepsProvider.getInstance().inject(ExponentViewKernel.class, this);

    try {
      sVersionName = mApplicationContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
    } catch (PackageManager.NameNotFoundException e) {
      EXL.e(TAG, e);
    } catch (Throwable e) {
      EXL.e(TAG, e);
    }
  }

  public String getVersionName() {
    return sVersionName;
  }

  @Override
  public void handleError(String errorMessage) {

  }

  @Override
  public void handleError(Exception exception) {

  }

  @Override
  public void openExperience(KernelConstants.ExperienceOptions options) {

  }

  @Override
  public void reloadVisibleExperience(String manifestUrl) {

  }
}
