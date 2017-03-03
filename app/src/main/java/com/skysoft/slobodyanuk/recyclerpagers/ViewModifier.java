/*
 ********************************************************************************
 * Copyright (c) 2012 Samsung Electronics, Inc.
 * All rights reserved.
 *
 * This software is a confidential and proprietary information of Samsung
 * Electronics, Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Samsung Electronics.
 ********************************************************************************
 */

package com.skysoft.slobodyanuk.recyclerpagers;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Abstract class defining a transformation that will be applied to a View.
 *
 * @author Artur Stepniewski <a.stepniewsk@samsung.com>
 *
 */
public abstract class ViewModifier {
	abstract void applyToView(View v, RecyclerView parent);
}
