package io.github.dekabrsky.androidMidSemester.data.repository

import io.github.dekabrsky.androidMidSemester.data.api.ESPNApi
import io.github.dekabrsky.androidMidSemester.domain.model.Match
import io.github.dekabrsky.androidMidSemester.domain.repository.MatchRepository
import toMatch
import toMatches
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EspnMatchRepositoryImpl(
    private val api: ESPNApi,
) : MatchRepository {

    override suspend fun matchesOn(date: LocalDate): List<Match> =
        api.getScoreboard(ESPNApi.DEFAULT_LEAGUE,date.format(DateTimeFormatter.BASIC_ISO_DATE)).toMatches()

    override suspend fun match(id: Long): Match =
        api.game(ESPNApi.DEFAULT_LEAGUE, id).header.toMatch()
}
