package com.shverma.booknexus.book.domain

import com.shverma.booknexus.core.domain.DataError
import com.shverma.booknexus.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}