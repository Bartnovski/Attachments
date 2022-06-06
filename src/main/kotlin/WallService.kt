object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        posts += if (posts.isEmpty()) post.copy(id = 1U)
        else post.copy(id = posts.last().id + 1U)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, oldPost) in posts.withIndex()) {
            if (oldPost.id == post.id) {
                posts[index] = post.copy(ownerId = oldPost.ownerId, date = oldPost.date)
                return true
            }
        }
        return false
    }

    fun createComment(postId: UInt, comment: Comment): Comment {
        for(post in posts){
            if(post.id == postId) {
                comments += comment
                return comment
            }
        }
        throw PostNotFoundException("No post with such id")
    }
}
