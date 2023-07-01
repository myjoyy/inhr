class NoteService<T : Note> {
    private val notes: MutableList<T> = mutableListOf()

    // Создание новой заметки у текущего пользователя
    fun add(note: T) {
        notes.add(note)
    }

    // Добавление нового комментария к заметке
    fun createComment(noteId: Int, comment: Comment) {
        val note = notes.find { it.id == noteId }
        note?.comments?.add(comment)
    }

    // Удаление заметки текущего пользователя
    fun delete(noteId: Int) {
        val note = notes.find { it.id == noteId }
        notes.remove(note)
    }

    // Удаление комментария к заметке
    fun deleteComment(noteId: Int, comment: Comment) {
        val note = notes.find { it.id == noteId }
        note?.comments?.remove(comment)
    }

    // Редактирование заметки текущего пользователя
    fun edit(noteId: Int, updatedNote: T) {
        val note = notes.find { it.id == noteId }
        note?.apply {
            title = updatedNote.title
            text = updatedNote.text
            // остальные свойства
        }
    }

    // Редактирование указанного комментария к заметке
    fun editComment(noteId: Int, comment: Comment, updatedComment: Comment) {
        val note = notes.find { it.id == noteId }
        note?.comments?.find { it == comment }?.apply {
            fromId = updatedComment.fromId
            text = updatedComment.text
        }
    }

    // Возвращает список заметок, созданных пользователем
    fun get(): List<T> {
        return notes.toList()
    }

    // Возвращает заметку по её id
    fun getById(noteId: Int): T? {
        return notes.find { it.id == noteId }
    }

    // Возвращает список комментариев к заметке
    fun getComments(noteId: Int): List<Comment> {
        val note = notes.find { it.id == noteId }
        return note?.comments ?: emptyList()
    }

    // Возвращает список заметок друзей пользователя
    fun getFriendsNotes(): List<T> {
        TODO()
        return emptyList()
    }

    // Восстанавливает удалённый комментарий
    fun restoreComment(noteId: Int, comment: Comment) {
        val note = notes.find { it.id == noteId }
        if (note?.comments?.contains(comment) == false) {
            note.comments.add(comment)
        }
    }

}
