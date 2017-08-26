package devos.wouter.moviereleases.model

data class NowPlayingResponse(var page: Int,
                              var totalResults: Int,
                              var totalPages: Int,
                              var dates: Dates,
                              var results: List<Movie>)