package net.gahfy.feedme.ui.post

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import net.gahfy.feedme.R
import net.gahfy.feedme.databinding.ItemPostBinding
import net.gahfy.feedme.model.Post
import net.gahfy.feedme.ui.detail.DetailActivity

/**
 * Adapter for the list of the posts
 * @property context Context in which the application is running
 */
class PostAdapter(private val context: Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    /**
     * The list of posts of the adapter
     */
    private var posts: List<Post> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemPostBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
        holder?.bind(posts[position])
        holder?.itemView?.setOnClickListener {
//            Log.i("help","help - "+position+" - "+posts[position].body)
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("title", posts[position].title)
            intent.putExtra("body", posts[position].body)
            startActivity(context,intent,null)

        }

    }



    /**
     * Updates the list of posts of the adapter
     * @param posts the new list of posts of the adapter
     */
    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for Post item
     */
    class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a post into the view
         */
        fun bind(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }
}