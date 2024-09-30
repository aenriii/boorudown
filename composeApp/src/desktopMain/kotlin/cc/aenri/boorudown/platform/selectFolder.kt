package cc.aenri.boorudown.platform

import cc.aenri.boorudown.util.None
import cc.aenri.boorudown.util.Option
import cc.aenri.boorudown.util.Some
import javax.swing.JFileChooser

fun selectFolder(): Option<String> {
    val f = JFileChooser(System.getProperty("os.home")).apply {
        fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
        dialogTitle = "Select Folder"
        approveButtonText = "Select"
    }
    f.showOpenDialog(null)
    return if (f.selectedFile != null) {
        Some(f.selectedFile.absolutePath.toString())
    } else {
        None()
    }
}