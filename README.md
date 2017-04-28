# Does Your Phone Work ?

Projet Android for Embedded Software Development based on Android at BJTU (Beijing Jiaotong University)

#### Motivation and ambition

The project was born during a Android Embedded Software Development course at Beijing Jiaotong University in China between two students who wanted to create an Android app entirely based on functionality. I (Vireth) think to make an Android application since the first time I started to learn JAVA languages. In love with programming, I wanted to share it through an easy access application so everybody can join and try it. "Does my phone work ?" ambition is to place programming in the middle of a funny, entertaining so everybody even beginners can enjoy programming and hopefully start learning programming languages afterward.

## Description

"Does my phone work ?" is a application on Android for testing your Android device.

The main story:

Do you want to buy a phone from someone ? But You don't know if the phone can works perfectly !
You can ask to the people to Download and Install "Does my phone work ?" and run all testing functionality.
You can check if the device can  works perfectly !

In this application you can run a lot of functionality of the device.
The user need to test some functionalitys.

Example: Bluetooth, the user need to turn on the bluetooth, search device and list !

The application will check inside if the device can run the bluetooth and say to the user.

## Structure

    .
    ├── manifests                       	# AndroidManifest.xml
    ├── java                    		# File Java
    │   ├── doesyourphonesuck		# Activity of all
    │   └── doesyourphonesuck (Test)	# Testing UI & Functionnality 
    ├── res					# File source for application
    │   ├── drawable			# Asset Picture
    │   ├── layout				# Template of all Activity
    │   ├── menu				# Template of menu
    │   ├── raw				# Asset music
    │   └── values				# Styles and String
    └── Gradle Scripts			# Gradle 3.3

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

Full code [here](https://github.com/vireth20/Android_BJTU/blob/master/mobile/src/main/java/com/example/vireth/doyourphonesuck/FlashActivity.java)

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

## Examples Api System Test

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

Full code [here](https://github.com/vireth20/Android_BJTU/blob/master/mobile/src/main/java/com/example/vireth/doyourphonesuck/FlashActivity.java)

## Examples Test Unitaire & UI

#### Keyboard Activity

	public void KeyboardActivityTest(View view) {
    		EditText KeyboardEditText =
            		(EditText) findViewById(R.id.KeyboardEditText);

    		String name = greetKeyboardText.getText().toString();
    		String greeting = String.format("Sun Wukong, %s!", name);

    		TextView messageTextView =
            	(TextView) findViewById(R.id.messageTextView);

    		messageTextView.setText(greeting);
	}

Full code [here](https://github.com/vireth20/Android_BJTU/blob/master/mobile/src/main/java/com/example/vireth/doyourphonesuck/Keyboard.java)

## List of functionnality

List of functionnality for all projets in BJTU

#### KEYCAM [here](https://github.com/keysim/keycam)
#### SUN WUKONG GAME [here](https://github.com/vireth20/Sun-Wukong-Android)



1 | 2 | 3
---|---|---
:white_check_mark: Information of Phone | :white_check_mark: WLAN | :white_check_mark: Fragment
:white_check_mark: Information of Sim | :white_check_mark: Bluetooth | :white_check_mark: Responsive
:white_check_mark: Camera Front/Back | :white_check_mark: GPS | :white_check_mark: Graphics
:white_check_mark: Flash | :white_check_mark: Map | :white_check_mark: Asynchronous
:white_check_mark: Camera button | :white_check_mark: Charging | :white_check_mark: Exception notification
:white_check_mark: Touch screen | :white_check_mark: Plug USB | :white_check_mark: Authentication
:white_check_mark: Display | :white_check_mark: Light sensor | :white_check_mark: Storage
:white_check_mark: Keyboard | :white_check_mark: Proximity | :white_check_mark: Database
:white_check_mark: Speaker Up/Down | :white_check_mark: Accelerometer | :white_check_mark: Mediaplayer
:white_check_mark: Call mode | :white_check_mark: Gyroscope | :white_check_mark: Sensor
:white_check_mark: Microphone | :white_check_mark: Test Unit | :white_check_mark: Session
:white_check_mark: Vibration | :white_check_mark: UI | :white_check_mark: Joystick
:white_check_mark: Volume button | :white_check_mark: Speech to Text | :white_check_mark: Compatibility

## Team & Credits

[![Keysim](https://raw.githubusercontent.com/keysim/gearobot/master/doc/img/keysim.png)](http://keysim.fr) | [![Vireth](https://raw.githubusercontent.com/keysim/gearobot/master/doc/img/vireth.png)](http://vireth.com)
---|---
:chicken: [Simon Menard](keysim.fr) | :monkey: [Vireth Thach sok](vireth.com)

## License

[The MIT License](http://opensource.org/licenses/MIT)

Copyright (c) 2017 Vireth
