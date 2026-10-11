# Experiment 1: Text-to-Speech Converter using EditText

## Aim
To design and develop an Android application containing a single EditText field in which the user can enter text, and a button labelled "Convert Text to Speech" which, on being clicked, converts the entered text into audible speech using the Android TextToSpeech (TTS) engine.

## Objectives
- To understand the basic structure and lifecycle of an Android application.
- To design a simple user interface using EditText and Button widgets.
- To handle click events using OnClickListener.
- To understand the working of the Android TextToSpeech (TTS) API.
- To validate user input before invoking the TTS engine.

## Procedure / Algorithm
1. Create a new Android project using Kotlin and Jetpack Compose.
2. Design the user interface in MainActivity.kt with a text input field and Convert Text to Speech button.
3. Initialize the Android TextToSpeech (TTS) engine and set the required language.
4. Read the text entered by the user when the button is clicked.
5. Check whether the input is empty; if empty, display a Toast message.
6. If valid text is entered, use TextToSpeech.speak() to convert the text into speech.
7. Stop and release the TTS resources in onDestroy().
8. Run the application on an emulator/device and verify that the entered text is spoken successfully.

## Source Code Files
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/example/texttospeech/MainActivity.kt`

## Result
Thus, an Android application with an EditText field and a "Convert Text to Speech" button was successfully designed and implemented, and the entered text was converted into audible speech using the Android TextToSpeech API.
