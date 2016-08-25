package testNewTech;

/**
 * Created by Administrator on 2016/8/23.
 */
public class BackUp {
    public BackUp(){
        /*
            //This section code is for test notification
            Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            // Verify it resolves
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;
            // Start an activity if it's safe
            if (isIntentSafe) {
                startActivity(mapIntent);
               // startActivityForResult(mapIntent);
            }


            /*Notification notification = NotificationUtilities.createNotification(this, R.drawable.small_mario,
                    "My first notification", "Hello Notification!", NotificationUtilities.FLAG_UPDATE_CURRENT);
            NotificationUtilities.notify(notification, 001, this);*//*




/*
   //This code is for call another activity
        //            Intent intent = new Intent(this, DisplayMessageActivity.class);
//            EditText editText = (EditText) findViewById(R.id.edit_message);
//            String message = editText.getText().toString();
//            intent.putExtra(EXTRA_MESSAGE, message);
//            startActivity(intent);

        */

        /*
        //This code is for set single image
        final ImageView mImageView;
            String url = "http://i.imgur.com/7spzG.png";
            mImageView = (ImageView) findViewById(R.id.myImage);
            //final RequestQueue queue = RequestQueueFactory.getRequestQueue(this);
            final RequestQueue queue = RequestQueueFactory.getRequestQueue(this);
            queue.start();
            // Retrieves an image specified by the URL, displays it in the UI.
            ImageRequest request = new ImageRequest(url,
                    new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap bitmap) {
                            //System.out.println("Everything is all right");
                            mImageView.setImageBitmap(bitmap);
                            queue.stop();
                        }
                    }, 0, 0, null,
                    new Response.ErrorListener() {
                        public void onErrorResponse(VolleyError error) {
                            //System.out.println("Everything is all wrong");
                            mImageView.setImageResource(R.drawable.image_load_error);
                            queue.stop();
                        }
                    });
            // Access the RequestQueue through your singleton class.
            queue.add(request);
            System.out.println("execution finish");
            Log.v("blah", "blah blah");*/



        /*//The following section code is for testing volley network functionality
        final TextView mTextView = (TextView) findViewById(R.id.text);

        // Instantiate the RequestQueue.
        //RequestQueue queue = Volley.newRequestQueue(this);

        final RequestQueue queue = RequestQueueFactory.getRequestQueue(this);

        queue.start();
        String url = "http://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println(response.substring(0, 500));
                        mTextView.setText("Response is: " + response.substring(0, 500));
                        queue.stop();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
                queue.stop();
            }
        });
        // Add the request to the RequestQueue.
        //RequestQueueFactory.getRequestQueue(this).add(stringRequest);
        queue.add(stringRequest);
        */
    }
}
