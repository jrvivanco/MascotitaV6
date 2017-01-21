package org.jrvivanco.mascotita;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by jrvivanco on 20/01/2017.
 */

public class NotificationIdTokenService extends FirebaseInstanceIdService {
    private static final String etiqueta = "Mascotita 6.0 >>>";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(etiqueta, "Token: " + token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
        Log.d(etiqueta, "Token: " + token);
    }
}
