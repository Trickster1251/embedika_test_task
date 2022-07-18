package org.walethea.embedika_test_task.responces

import java.util.Date

class DBStatsJSONResponse(
    val http_code: Int,
    val first_record_be_created: Date?,
    val last_record_be_created: Date?,
    val record_count: Int,
)