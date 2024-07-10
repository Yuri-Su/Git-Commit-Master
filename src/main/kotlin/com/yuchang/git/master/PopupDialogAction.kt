package com.yuchang.git.master

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.awt.ComposePanel
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JComponent


/**
 * @description 创建Action
 * @author yurisu
 * @version
 * @date 2024/7/3 22:17:03
 */
class PopupDialogAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        SampleDialog(event.project).show()
    }

    class SampleDialog(project: Project?) : DialogWrapper(project) {

        init {
            title = "Compose Sample"
            init()
        }

        override fun createCenterPanel(): JComponent {
            return ComposePanel().apply {
                setBounds(0, 0, 800, 600)
                setContent {
                    // 这里嵌入我们之前写好的计数器界面
                    MaterialTheme {
                        App()
                    }
                }
            }
        }
    }

}