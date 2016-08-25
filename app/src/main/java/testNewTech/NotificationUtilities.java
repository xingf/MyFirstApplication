package testNewTech;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Administrator on 2016/8/18.
 */
public class NotificationUtilities {

    public static int FLAG_CANCEL_CURRENT = PendingIntent.FLAG_CANCEL_CURRENT;
    public static int FLAG_IMMUTABLE = PendingIntent.FLAG_IMMUTABLE;
    public static int FLAG_NO_CREATE = PendingIntent.FLAG_NO_CREATE;
    public static int FLAG_ONE_SHOT = PendingIntent.FLAG_ONE_SHOT;
    public static int FLAG_UPDATE_CURRENT = PendingIntent.FLAG_UPDATE_CURRENT;

    public static NotificationCompat.Builder createNotification(android.content.Context source){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(source);
        return mBuilder;
    }

    public static Notification createNotification(Context context,int smallIcon, CharSequence contentTitle, CharSequence contentText, int pendingIntentFlag){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(smallIcon);
        mBuilder.setContentTitle(contentTitle);
        mBuilder.setContentText(contentText);



        mBuilder.setContentIntent(createPendingIntent(context, pendingIntentFlag));
        return mBuilder.build();
    }

    private static PendingIntent createPendingIntent(Context context, int pendingIntentFlag){
        Intent resultIntent = new Intent(context, NotificationActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        pendingIntentFlag
                );

        return resultPendingIntent;
    }


    public static void notify(Notification notification, int notificationID, Context context){
        NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyMgr.notify(notificationID, notification);
    }
}
