package com.onepartcarbon.zendesk;

import android.content.Context;
import android.app.Activity;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zendesk.sdk.network.impl.ZendeskConfig;
import com.zendesk.sdk.model.access.AnonymousIdentity;
import com.zendesk.sdk.model.access.Identity;
import com.zendesk.sdk.support.SupportActivity;

public class ZendeskPlugin extends CordovaPlugin {

  @Override
  protected void pluginInitialize() {
    Context context = cordova.getActivity().getApplicationContext();
    ZendeskConfig.INSTANCE.init(context, "", "", "");
    Identity identity = new AnonymousIdentity.Builder().build();
    ZendeskConfig.INSTANCE.setIdentity(identity);
  }

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if("showHelpCentre".equals(action)) {
      Activity context = this.cordova.getActivity();
      new SupportActivity.Builder().show(context);
    }
    return false;
  }
}
