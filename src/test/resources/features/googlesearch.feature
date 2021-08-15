Feature: Google search testing

 @Perf
 Scenario: Launch Browser And Enter Url
 Given I Launch Chrome And I Enter Google Url
  Given I log "OPEN_GOOGLE_PAGE" start time
 Then Google Page is opened
  Then I log "OPEN_GOOGLE_PAGE" finish time
 When I enter search text as "automation testing"
  Given I log "SEARCH_TEXT" start time
 Then search is successful
  Then I log "SEARCH_TEXT" finish time