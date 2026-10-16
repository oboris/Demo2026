package ua.edu.cdu.boris.demo2026.model

data class HorizontalList(
    val authorList: List<Author>,
    override val id: Int
): MyListable