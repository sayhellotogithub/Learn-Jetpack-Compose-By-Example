package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.px
import androidx.ui.core.setContent
import androidx.ui.core.sp
import androidx.ui.engine.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.Shadow
import androidx.ui.layout.Column
import androidx.ui.layout.FlexRow
import androidx.ui.material.Divider
import androidx.ui.text.ParagraphStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.text.style.TextDecoration
import androidx.ui.text.style.TextIndent
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class CustomTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This is an extension function of Activity that sets the @Composable function that's
        // passed to it as the root view of the activity. This is meant to replace the .xml file
        // that we would typically set using the setContent(R.id.xml_file) method. The setContent
        // block defines the activity's layout.
        setContent {
            // Here, Message is a Composable function which is going to describe the contents of
            // this activity that will be rendered on the screen.
            Column {
                CustomStyledText("This is the default text style")

                Divider(color = Color.Gray)

                CustomStyledText("This text is blue in color",
                    style = TextStyle(
                        color = Color.Blue
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text has a bigger font size",
                    style = TextStyle(
                        fontSize = 30.sp
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text is bold",
                    style = TextStyle(
                        fontWeight = FontWeight.W700
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text is italic",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text is using a custom font family",
                    style = TextStyle(
                        fontFamily = FontFamily.Cursive
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text has an underline",
                    style = TextStyle(
                        decoration = TextDecoration.Underline
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text has a strikethrough line",
                    style = TextStyle(
                        decoration = TextDecoration.LineThrough
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text will add an ellipsis to the end of the " +
                        "text if the text is longer that 1 line long.",
                    maxLines = 1
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text has a shadow",
                    style = TextStyle(
                        shadow = Shadow(color = Color.Black, blurRadius = 10.px,
                            offset = Offset(2f, 2f)
                        )
                    )
                )

                Divider(color = Color.Gray)

                FlexRow {
                    expanded(1f) {
                        CustomStyledText("This text is center aligned",
                            paragraphStyle = ParagraphStyle(
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }

                Divider(color = Color.Gray)

                CustomStyledText("This text will demonstrate how to justify your " +
                        "paragraph to ensure that the text that ends with a soft line break " +
                        "spreads and takes the entire width of the container",
                    paragraphStyle = ParagraphStyle(
                        textAlign = TextAlign.Justify
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("This text will demonstrate how to add indentation " +
                        "to your text. In this example, indentation was only added to the first " +
                        "line. You also have the option to add indentation to the rest of the " +
                        "lines if you'd like",
                    paragraphStyle = ParagraphStyle(
                        textAlign = TextAlign.Justify,
                        textIndent = TextIndent(firstLine = 30.sp)
                    )
                )

                Divider(color = Color.Gray)

                CustomStyledText("The line height of this text has been increased " +
                        "hence you will be able to see more space between each line in this " +
                        "paragraph.",
                    paragraphStyle = ParagraphStyle(
                        textAlign = TextAlign.Justify,
                        lineHeight = 20.sp
                    )
                )
            }
        }
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions.
@Composable
fun CustomStyledText(displayText: String, style: TextStyle? = null, maxLines: Int? = null,
                     paragraphStyle: ParagraphStyle? = null) {
    // We should think of composable functions to be similar to lego blocks - each composable
    // function is in turn built up of smaller composable functions. Here, the Text() function is
    // pre-defined by the Compose UI library; you call that function to declare a text element
    // in your app.
    Text(text = displayText, style = style, maxLines = maxLines, overflow = TextOverflow.Ellipsis,
        paragraphStyle = paragraphStyle)
}

// Android Studio lets you preview your composable functions within the IDE itself, instead of
// needing to download the app to an Android device or emulator. This is a fantastic feature as you
// can preview all your custom components(read composable functions) from the comforts of the IDE.
// The main restriction is, the composable function must not take any parameters. If your composable
// function requires a parameter, you can simply wrap your component inside another composable
// function that doesn't take any parameters and call your composable function with the appropriate
// params. Also, don't forget to annotate it with @Preview & @Composable annotations.
@Preview
@Composable
fun CustomStyledTextPreview() {
    CustomStyledText("This is preview text",
        maxLines = 2,
        style = TextStyle(
            color = Color.Red,
            fontWeight = FontWeight.W900,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp
        ),
        paragraphStyle = ParagraphStyle(
            textAlign = TextAlign.Justify
        )
    )
}