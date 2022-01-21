package mehdiparsaei.simonsvoss.assignment.data.remote.response

import mehdiparsaei.simonsvoss.assignment.domain.model.Building
import mehdiparsaei.simonsvoss.assignment.domain.model.Group
import mehdiparsaei.simonsvoss.assignment.domain.model.Lock
import mehdiparsaei.simonsvoss.assignment.domain.model.Media

data class ApiResponse(
    val buildings: List<Building>,
    val groups: List<Group>,
    val locks: List<Lock>,
    val media: List<Media>
)