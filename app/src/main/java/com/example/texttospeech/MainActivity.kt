package com.example.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

class MainActivity : ComponentActivity() {
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.US
            } else {
                Toast.makeText(
                    this,
                    "Text-to-Speech initialization failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        setContent {
            MaterialTheme {
                TextToSpeechScreen(
                    onSpeak = { text ->
                        if (text.isBlank()) {
                            Toast.makeText(
                                this,
                                "Please enter some text",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            textToSpeech?.speak(
                                text,
                                TextToSpeech.QUEUE_FLUSH,
                                null,
                                "TTS_ID"
                            )
                        }
                    }
                )
            }
        }
    }

    override fun onDestroy() {
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        textToSpeech = null
        super.onDestroy()
    }
}

@Composable
fun TextToSpeechScreen(
    onSpeak: (String) -> Unit
) {
    var inputText by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Text-to-Speech Converter",
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            OutlinedTextField(
                value = inputText,
                onValueChange = {
                    inputText = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Enter Text")
                },
                placeholder = {
                    Text("Type something here...")
                },
                singleLine = false
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {
                    onSpeak(inputText.text)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Convert Text to Speech"
                )
            }
        }
    }
}
