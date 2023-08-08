from itertools import product

def calculate_waiting_time(mentor_distribution, reqs, k):
    waiting_time = 0
    mentors = [0] * len(mentor_distribution)

    for req in reqs:
        request_time, consultation_time, consultation_type = req
        available_mentors = [i for i in range(len(mentor_distribution)) if mentor_distribution[i] == consultation_type]
        min_finish_time = 1e9
        chosen_mentor = -1

        for mentor in available_mentors:
            if mentors[mentor] <= request_time:
                chosen_mentor = mentor
                break
            if mentors[mentor] < min_finish_time:
                min_finish_time = mentors[mentor]
                chosen_mentor = mentor

        if mentors[chosen_mentor] > request_time:
            waiting_time += mentors[chosen_mentor] - request_time
        mentors[chosen_mentor] = max(request_time, mentors[chosen_mentor]) + consultation_time

    return waiting_time


def solution(k, n, reqs):
    min_waiting_time = 1e9
    for mentor_distribution in product(range(1, k+1), repeat=n):
        if len(set(mentor_distribution)) != k:
            continue
        waiting_time = calculate_waiting_time(mentor_distribution, reqs, k)
        min_waiting_time = min(min_waiting_time, waiting_time)

    return min_waiting_time