package com.yuchang.git.master

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.pom.Navigatable


/**
 * @description 创建Action
 * @author yurisu
 * @version
 * @date 2024/7/3 22:17:03
 */
class PopupDialogAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {

        //创建并显示对话框
        val currentProject: Project? = event.project
        val message: StringBuilder =
            StringBuilder(event.presentation.text + " Selected!")

        //如果选中了一个元素，追加该元素的信息
        val selectedElement: Navigatable? = event.getData(CommonDataKeys.NAVIGATABLE)
        if (selectedElement != null) {
            message.append("Selected Element: ").append(selectedElement)
        }
        val title: String = event.getPresentation().getDescription()
        Messages.showMessageDialog(
            currentProject,
            message.toString(),
            title,
            Messages.getInformationIcon()
        )
    }
}