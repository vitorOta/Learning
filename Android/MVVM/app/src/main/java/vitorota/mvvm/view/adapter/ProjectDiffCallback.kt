package vitorota.mvvm.view.adapter

import android.support.v7.util.DiffUtil
import vitorota.mvvm.service.model.Project

class ProjectDiffCallback : DiffUtil.ItemCallback<Project>() {
    override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean =
        oldItem != null &&
                oldItem.id == newItem.id &&
                oldItem.git_url == newItem.git_url

}