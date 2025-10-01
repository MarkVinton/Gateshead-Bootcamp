import pandas as pd
import numpy as np
surveys_df = pd.read_csv("surveys.csv")
#Activity 1

#print(surveys_df.columns)

#Returns (35549,9) shows the number of columns and rows
#print(surveys_df.shape)

#print(surveys_df.head())

#Returns the first 15 rows of the data
#print(surveys_df.head(15))

#print(surveys_df.tail())

#Activity 2

#site_names = pd.unique(surveys_df['plot_id'])

#Returns a list of all the unique site names
#print(site_names)

#Returns the amount of unique site names
#print(surveys_df['plot_id'].nunique())

#Also returns the amount of unique site names
#print(len(sites_names))

#Activity 3
#Shows the amount of female and males

#female_and_males=surveys_df.groupby('sex')['record_id'].count()
#print(female_and_males)

#This shows the mean of every Female and Male in every site

grouped_data2=surveys_df.groupby(['plot_id','sex'])
#print(grouped_data2.mean(numeric_only=True))

#Shows the summary of weight values for every site.
sites=surveys_df.groupby('plot_id')
#print(sites['weight'].describe())

#Activity 4

#species_list = surveys_df.groupby('species_id').count()
#print(species_list)

#Activity 5

#Create a plot of average weight across all species per site.
# Average weight across all species per site

import matplotlib.pyplot as plt
avg_weight_site = surveys_df.groupby('plot_id')['weight'].mean(numeric_only=True)
avg_weight_site.plot(kind='bar')
#plt.show()

men_women = surveys_df['sex'].value_counts()[['M','F']]
men_women.plot(kind='bar')
#plt.show()

#Challenge
weight_sum = surveys_df.groupby(['plot_id', 'sex'])['weight'].sum()
weight_sum = weight_sum.plot(kind='bar', stacked=True)
plt.show()

 