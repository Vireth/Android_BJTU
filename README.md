# Does Your Phone Work ?
Projet Android for BJTU

This projet is [...]

## Description

Description du projet here

## Examples Activity

#### Flash Activity

    /.../
    
    mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
    
    try {
	mCameraId = mCameraManager.getCameraIdList()[0];
    } catch (CameraAccessException e) {
	e.printStackTrace();
    }

    try {
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
	    mCameraManager.setTorchMode(mCameraId, true);
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
    
    /.../

Full code [here](https://github.com/vireth20/Android_BJTU/blob/master/mobile/src/main/java/com/example/vireth/doyourphonesuck/CameraFront.java)

#### Camera Activity

    @Override
    public void onCreate(Bundle savedInstanceState) {
        /.../
	
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
	
Full code [here](https://github.com/vireth20/Android_BJTU/blob/master/mobile/src/main/java/com/example/vireth/doyourphonesuck/CameraFront.java)

## Examples Test

#### Flash Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /.../

        Boolean isFlashAvailable = getApplicationContext().getPackageManager()
		.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isFlashAvailable) {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Error !!");
            alert.setMessage("Your device doesn't support flash light!");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);
                }
            });
            alert.show();
            return;
    }

## Team & Credits

[![Keysim](https://raw.githubusercontent.com/keysim/gearobot/master/doc/img/keysim.png)](http://keysim.fr) | [![Vireth](https://raw.githubusercontent.com/keysim/gearobot/master/doc/img/vireth.png)](http://vireth.com)
---|---
[Simon Menard](keysim.fr) | [Vireth Thach sok](vireth.com)

## License

[The MIT License](http://opensource.org/licenses/MIT)

Copyright (c) 2017 Vireth
