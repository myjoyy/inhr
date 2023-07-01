import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NoteServiceTest {

    private lateinit var noteService: NoteService<Note>

    @Before
    fun setUp() {
        noteService = NoteService()
    }

    @Test
    fun testAdd() {
        val note = Note(1, "Заметка", "Текст заметки", 12345, mutableListOf(), 0, "", "", 1, "")
        noteService.add(note)
        val allNotes = noteService.get()
        assertEquals(1, allNotes.size)
        assertEquals(note, allNotes[0])
    }

    @Test
    fun testCreateComment() {
        val note = Note(1, "Заметка", "Текст заметки", 12345, mutableListOf(), 0, "", "", 1, "")
        noteService.add(note)

        val comment = Comment(2, 111, 2,"Комментарий к заметке", 1, 1, 1,1, 2,3,1,1)
        noteService.createComment(1, comment)

        val noteComments = noteService.getComments(1)
        assertEquals(1, noteComments.size)
        assertEquals(comment, noteComments[0])
    }

    @Test
    fun testDelete() {
        val note = Note(1, "Заметка", "Текст заметки", 12345, mutableListOf(), 0, "", "", 1, "")
        noteService.add(note)
        noteService.delete(1)
        val remainingNotes = noteService.get()
        assertTrue(remainingNotes.isEmpty())
    }

    @Test
    fun testDeleteComment() {
        val note = Note(1, "Заметка", "Текст заметки", 12345, mutableListOf(), 0, "", "", 1, "")
        noteService.add(note)

        val comment = Comment(1, 111, 2,"Комментарий к заметке", 1, 1, 1,1, 2,3,1,1)
        noteService.createComment(1, comment)

        noteService.deleteComment(1, comment)

        val noteComments = noteService.getComments(1)
        assertTrue(noteComments.isEmpty())
    }

    @Test
    fun testEdit() {
        val note = Note(1, "Заметка", "Текст заметки", 12345, mutableListOf(), 0, "", "", 1, "")
        noteService.add(note)

        val updatedNote = Note(1, "Обновленная заметка", "Обновленный текст заметки", 12345, mutableListOf(), 0, "", "", 1, "")
        noteService.edit(1, updatedNote)

        val editedNote = noteService.getById(1)
        assertEquals(updatedNote, editedNote)
    }

    @Test
    fun testEditComment() {
        val note = Note(1, "Заметка", "Текст заметки", 12345, mutableListOf(), 0, "", "", 1, "")
        noteService.add(note)

        val comment = Comment(1,111, 22,"Комментарий", "Комментарий к заметке", 1, 1, 1,1, 2,3,1)
        noteService.createComment(1, comment)

        val updatedComment = Comment(1,111, 22,"Комментарий", "Комментарий к заметке", 1, 1, 1,1, 2,3,1)
        noteService.editComment(1, comment, updatedComment)

        val noteComments = noteService.getComments(1)
        assertEquals(1, noteComments.size)
        assertEquals(updatedComment, noteComments[0])
    }


}