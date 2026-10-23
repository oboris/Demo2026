package ua.edu.cdu.boris.demo2026.repository

import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.HorizontalList
import ua.edu.cdu.boris.demo2026.model.MyListable

class AppRepositoryImpl: AppRepository {

    val myAuthorList: List<Author> = listOf(
        Author("11 Author", "11/11/2022", id = 1),
        Author("22 Author", "11/11/2022", id = 2),
        Author("33 Author", "11/11/2022", id = 3),
        Author("44 Author", "11/11/2022", id = 4),
        Author("55 Author", "11/11/2022", id = 5),
    )
    val myAppList: List<MyListable> = listOf(
        Book(
            author = null,
            pages = 200,
            title = "Book 1",
            id = 0
        ),
        Book("Book 2", 300, myAuthorList[0], id = 1),
        Book("Book 3", 30, myAuthorList[1], id = 2),
        myAuthorList[2],
        Book("Book 4", 80, myAuthorList[2], id = 3),
        HorizontalList(myAuthorList, 100),
        Book("Book 22", 300, myAuthorList[3], id = 4),
        Book("Book 33", 30, myAuthorList[4], id = 5),
        Book("Book 44", 80, myAuthorList[0], id = 6),
        Book("Book 23", 300, myAuthorList[3], id = 7),
        myAuthorList[0],
        Book("Book 31", 30, myAuthorList[0], id = 8),
        Book("Book 41", 80, myAuthorList[2], id = 9),
        Book("Book 21", 300, myAuthorList[0], id = 10),
        Book("Book 31", 30, myAuthorList[1], id = 11),
        myAuthorList[3],
        Book("Book 42", 80, myAuthorList[0], id = 12),
        Book("Book 25", 300, myAuthorList[4], id = 13),
        myAuthorList[1],
        Book("Book 35", 30, myAuthorList[2], id = 14),
        Book("Book 45", 80, myAuthorList[0], id = 15),
        myAuthorList[4],
    )


    override fun getAllData(): List<MyListable> {
        return myAppList
    }
}