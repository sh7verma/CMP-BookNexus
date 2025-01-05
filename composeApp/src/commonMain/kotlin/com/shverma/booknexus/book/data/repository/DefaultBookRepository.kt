package com.shverma.booknexus.book.data.repository


import com.shverma.booknexus.book.data.mappers.toBook
import com.shverma.booknexus.book.data.network.RemoteBookDataSource
import com.shverma.booknexus.book.domain.Book
import com.shverma.booknexus.book.domain.BookRepository
import com.shverma.booknexus.core.domain.DataError
import com.shverma.booknexus.core.domain.Result
import com.shverma.booknexus.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

}