package io.github.dekabrsky.androidMidSemester.di

import io.github.dekabrsky.androidMidSemester.data.repository.EspnMatchRepositoryImpl
import io.github.dekabrsky.androidMidSemester.data.repository.MatchRepositoryImpl
import io.github.dekabrsky.androidMidSemester.data.repository.MatchesCache
import io.github.dekabrsky.androidMidSemester.domain.repository.MatchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MatchRepository> { MatchRepositoryImpl(get()) }
    single<MatchesCache> { MatchesCache() }
    single<MatchRepository> { EspnMatchRepositoryImpl(get()) }
}
