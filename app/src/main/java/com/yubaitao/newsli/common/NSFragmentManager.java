package com.yubaitao.newsli.common;

import android.os.Bundle;

public interface NSFragmentManager {

    void doFragmentTransaction(NSBasicFragment basicFragment);

    void startActivityWithBundle (Class<?> clazz , boolean isFinished , Bundle bundle);

    void showSnackBar (String message);

}
