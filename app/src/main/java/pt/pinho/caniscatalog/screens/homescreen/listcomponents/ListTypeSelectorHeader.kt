package pt.pinho.caniscatalog.screens.homescreen.listcomponents

import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pt.pinho.caniscatalog.R

@Composable
fun ListTypeSelectorHeader(switchValue: MutableState<Boolean>)
{
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Text(text = stringResource(R.string.show_list_as_grid))
        Spacer(modifier = Modifier.width(12.dp))
        Switch(checked = switchValue.value, onCheckedChange = { switchValue.value = it })
    }
}