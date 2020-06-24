module radioa.notifications {

 exports notifications.model to radioa.main;
 exports notifications.persistence to radioa.main;

 requires radioa.userprofile;
 requires radioa.competition;
 requires leansoft.bigqueue;
 
}