/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.screens.auth.login.interactor.callback;

import com.liferay.mobile.android.task.callback.typed.JSONObjectAsyncTaskCallback;
import com.liferay.mobile.screens.auth.login.interactor.event.LoginEvent;
import com.liferay.mobile.screens.util.EventBusUtil;

import org.json.JSONObject;

/**
 * @author Silvio Santos
 */
public class LoginCallback extends JSONObjectAsyncTaskCallback {

	@Override
	public void onFailure(Exception e) {
		EventBusUtil.post(new LoginEvent(LoginEvent.REQUEST_FAILED, e));
	}

	@Override
	public void onSuccess(JSONObject jsonObject) {
		EventBusUtil.post(new LoginEvent(LoginEvent.REQUEST_SUCCESS));
	}

}