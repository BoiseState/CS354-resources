#include "Job.h"


JobPtr createJob(int jobid, char *info) {
    JobPtr newJob = (JobPtr) malloc(sizeof(Job));
    newJob->jobid = jobid;
    newJob->info = (char *) malloc(sizeof(char) * (strlen(info) + 1));
    strcpy(newJob->info, info);
    return newJob;
}

//TODO the type! 
char *jobToString(const void *job) {
    JobPtr theRealJob = (JobPtr) job;
    char *temp;
    temp = (char *) malloc(sizeof(char) * strlen(theRealJob->info) + 1 + MAXPID_DIGITS + 4);
    sprintf(temp, "[%d] %s", theRealJob->jobid, theRealJob->info);
    return temp;
}

//TODO the type! 
void freeJob(void *job) {
    if (job == NULL)
	return;

    JobPtr theRealJob = (JobPtr) job;
    free(theRealJob->info);
    free(theRealJob);
}
