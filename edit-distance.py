import Levenshtein
import numpy as np
import random
import string


def edit_distance(s, t):

    prefix_matrix = np.zeros((len(s) + 1, len(t) + 1))
    prefix_matrix[:, 0] = list(range(len(s) + 1))
    prefix_matrix[0, :] = list(range(len(t) + 1))
    for i in range(1, len(s) + 1):
        for j in range(1, len(t) + 1):
            insertion = prefix_matrix[i, j - 1] + 1
            deletion = prefix_matrix[i - 1, j] + 1
            match = prefix_matrix[i - 1, j - 1]
            if s[i - 1] != t[j - 1]:
                match += 1
            prefix_matrix[i, j] = min(insertion, deletion, match)
    return int(prefix_matrix[i, j])


def id_generator(size, chars=string.ascii_uppercase + string.digits):
    return "".join(random.choice(chars) for _ in range(size))


def generate_random_string(min=1, max=20):
    size = random.randint(min, max)
    return id_generator(size)


random.seed(100)
random_strings1 = [generate_random_string() for _ in range(1000)]
random_strings2 = [generate_random_string() for _ in range(1000)]

edit_distances_montana = [
    edit_distance(a, b) for a, b in zip(random_strings1, random_strings2)
]
edit_distances_lev = [
    Levenshtein.distance(a, b) for a, b in zip(random_strings1, random_strings2)
]

edit_distances_montana == edit_distances_lev
