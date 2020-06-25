module radioa.notifications {

 exports notifications.model to radioa.main;
 exports notifications.infrastructure to radioa.main;

 requires radioa.userprofile;
 requires radioa.competition;
 requires leansoft.bigqueue;
 
}