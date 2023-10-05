package nl.jaysh.network.ktor.resource

import io.ktor.resources.Resource

@Resource("everything")
internal class EverythingResource(val q: String? = null)
