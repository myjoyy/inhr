fun main() {
    val post = Post(1,2,3,emptyArray(),true,"Hello, world!",true,10,5,"Simple",true,true,true,false,false,1, emptyArray(),)
    WallService.add(post)
    WallService.add(post)
    println(WallService.update(Post(
        2,
        2,
        3,
        emptyArray(),
        true,
        "Kotlin",
        true,
        10,
        5,
        "Simple",
        true,
        true,
        true,
        false,
        false,
        2,
        emptyArray(),
    )))
    WallService.createComment(2, Comment( //измените postId на 1 или 2 для успешного создания комментария
        2,
        2,
        3,
        "Hello, COMMENT",
        null,
        null,
        null,
        null,
        null,
        null ))
    WallService.printAll()
}

