import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {
    val placeholder = Placeholder()
    val donut = Donut(false, 1U, placeholder, false, "")
    val view = Views(1U)
    val reports = Reposts(1U, false)
    val likes = Likes(1U, false, false, false)
    val copyright = Copyright(1U, "", "", "")
    val comments = Comments(1U, false, false, false, false)

    @Test
    fun wallServiceAdd() {
        val service = WallService
        val result = service.add(
            Post(
                10645U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comments, null, likes, reports, view,
                1U, false, false, false, false, false, false, donut, 1U
            )
        )
        assertNotEquals(0, result.id)
    }

    @Test
    fun updateExistingTrue() {
        val service = WallService
        service.add(
            Post(
                1U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comments, copyright, likes, reports, view,
                1U, false, false, false, false, false, false, null, 1U
            )
        )
        service.add(
            Post(
                2U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, null, copyright, likes, reports, view,
                1U, false, false, false, false, false, false, donut, 1U
            )
        )
        service.add(
            Post(
                3U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comments, copyright, likes, null, null,
                1U, false, false, false, false, false, false, donut, 1U
            )
        )

        val update = Post(
            3U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, null, null, likes, null, null,
            1U, false, false, false, false, false, false, null, 1U
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateExistingFalse() {
        val service = WallService
        service.add(
            Post(
                10645U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comments, copyright, likes, reports, view,
                1U, false, false, false, false, false, false, donut, 1U
            )
        )
        service.add(
            Post(
                9578U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comments, copyright, likes, reports, view,
                1U, false, false, false, false, false, false, donut, 1U
            )
        )
        service.add(
            Post(
                4875U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comments, copyright, likes, reports, view,
                1U, false, false, false, false, false, false, donut, 1U
            )
        )

        val update = Post(
            36765U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, comments, copyright, likes, reports, view,
            1U, false, false, false, false, false, false, donut, 1U
        )

        val result = service.update(update)

        assertFalse(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService
        val comment = Comment(0,0,0,"",null,0,0,null,null)
        val post = Post(
            1U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, null, null, null, null, null,
            1U, false, false, false, false, false, false, null, 1U
        )
        service.add(post)
        service.createComment(11U,comment)
    }

    @Test
    fun shouldNotThrow() {
        val service = WallService
        val comment = Comment(0,0,0,"",null,0,0,null,null)
        val post = Post(
            1U, 1U, 1U, 1U, 1U, "", 1U, 1U, true, null, null, null, null, null,
            1U, false, false, false, false, false, false, null, 1U
        )
        service.add(post)
        service.createComment(1U,comment)
    }
}