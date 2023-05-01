fun main() {
    val post = Post(1, 2, 3, emptyArray(), null, "Hello, world!", true, 10, 5, "Simple", true, true, true, false, false, 1)
    WallService.add(post)
    WallService.add(post)
    WallService.printAll()
    println(WallService.update(Post(2, 2, 3, emptyArray(), null, "Kotlin", true, 10, 5, "Simple", true, true, true, false, false, 2)))
    WallService.printAll()
}
