# Spam-Reduce
Spam has become the platform of choice used by cyber-criminals to spread malicious payloads such as viruses and trojans.
In this project, we consider the problem of early detection of spam campaigns. Collaborative spam detection techniques can deal with large scale e-mail data contributed by multiple sources; however, they have the well-known problem of requiring disclosure of e-mail content.
Distance-preserving hashes are one of the common solutions used for preserving the privacy of e-mail content while enabling message classification for spam detection.
However, distance-preserving hashes are not scalable, thus making large-scale collaborative solutions difficult to implement.
As a solution, through this project, we propose Spam-Reduce, a Big Data privacy-preserving collaborative spam detection platform built on top of a standard Map Reduce facility.
Spam-Reduce uses a highly parallel encoding technique that enables the detection of spam campaigns in competitive times.
We evaluate our system’s performance using a huge synthetic spam base and show that our technique performs favourably against the creation and delivery overhead of current spam generation tools.
