package com.example.composecomponents

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecomponents.data.CheckInfo
import com.example.composecomponents.data.Routes
import com.example.composecomponents.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    var myText by remember { mutableStateOf("") }
//                    MyTextField(
//                        modifier = Modifier.padding(innerPadding),
//                        name = "Holi"
//
//                    ) {
//                        myText = it
//                    }
//                    MyIcon(modifier = Modifier.padding(innerPadding))
//                    MyCheckboxWithText(modifier = Modifier.padding(innerPadding))
//                    var status by rememberSaveable { mutableStateOf(false) }
//                    val checkInfo = CheckInfo(
//                        title = "Este es el bueno",
//                        selected = status,
//                        onCheckedChange = { myNewStatus -> status = myNewStatus })
//                    MyCheckboxWithTextCompleted(checkInfo = checkInfo)

//                    val myOptions = getOptions(listOf("Kevyn","Ejemplo","Pokemon"))
//                    var selected by rememberSaveable { mutableStateOf("Kevyn") }
//                    Column (modifier = Modifier.padding(innerPadding)){
//                        MyTriStatusCheckbox()
//                        myOptions.forEach{
//                            MyCheckboxWithTextCompleted(checkInfo = it)
//                        }
//                        MyRadioButtonListHoistin (name = selected, onItemSelected = { selected = it})
                    //MyCard(modifier = Modifier.padding(innerPadding))
                    //MyBadgeBox(modifier = Modifier.padding(innerPadding))
//                    MyDropdown(modifier = Modifier.padding(innerPadding))
                    // AlertDialogDoc(modifier = Modifier.padding(innerPadding))
//                    var show by remember { mutableStateOf(true) }
//                    ConfirmationDialog(Modifier.padding(innerPadding),show = show, onDismiss = {show=false})
//                    SuperHeroStickyView(modifier = Modifier.padding(innerPadding))
//                    val navigationController = rememberNavController()
//                    NavHost(
//                        navController = navigationController,
//                        //parecido a un enum cambiar en todos lados por routes.pantalla...
//                        startDestination = { Routes.Pantalla1.route }) {
//                        composable("pantalla1") { Screen1(navigationController) }
//                        composable("pantalla2") { Screen2(navigationController) }
//                        composable("pantalla3") { Screen3(navigationController) }
//                        composable("pantalla4/{name}") { backStackEntry ->
//                            Screen4(
//                                navigationController,
//                                backStackEntry.arguments?.getString("name").orEmpty()
//                            )
//                        }
//                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeComponentsTheme {
        TestComponent()
    }
}

@Composable
fun TestComponent() {
    MyTextField(name = "Holi2") { }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus })
    }

}

