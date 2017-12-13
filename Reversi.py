'''
Created on Dec 3, 2017

@author: Johnny Tsao
'''
from visual import*

L_box = 0.001
board_width = 0.02*L_box
disk_width = board_width
disk_radius = L_box/2*0.8
lines_length = 0.06*L_box
lines_width = board_width*1.02
Nx,Ny=8,8
def get_data():
    open_file = open('test.txt','r')
    a = open_file.readlines()
    new = zeros((Nx,Ny))
    k=0
    for i in range(Nx):
        for j in range(Ny):
            new[i][j] = int(a[k])
            k+=1
    open_file.close()
    return new

def game():
    scene=display(title='Reversi',height=1000,width=1000,center=(L_box*Nx/2,L_box*Ny/2,0),range=0.25,background=(0.9,0.9,0.8))
    scene.range = 0.008*(Nx*Ny)**0.5/8
    time=label(text='t=0',align='right',height=0.3,pos=vector(-L_box,0,0),axis=vector(1,0,0),forward=vector(0,0,1), depth=-0.01, color=color.black)
    board = empty(shape=(Nx,Ny), dtype=object)
    disk = empty(shape=(Nx,Ny), dtype=object)
    Lines_row = empty(shape=(Ny+1), dtype=object)
    Lines_col = empty(shape=(Nx+1), dtype=object)
    ##initialize
    for i in range(Nx):
        for j in range(Ny):
            board[i][j] = box(opacity=1.,pos=vector((i+0.5)*L_box,(j+0.5)*L_box,0),length=L_box,height=L_box,width=board_width,color=(0.3,0.7,0.3))
            disk[i][j] = cylinder(opacity=0., pos=vector((i+0.5)*L_box,(j+0.5)*L_box,board_width), color=board[i][j].color,radius=disk_radius,axis = vector(0,0,disk_width))
    for i in range(Ny+1):
        Lines_row[i] = box(pos=vector(Nx/2*L_box,i*L_box,0), length=Nx*L_box, height=lines_length, width=lines_width, color=color.black)
    for i in range(Nx+1):
        Lines_col[i] = box(pos=vector(i*L_box,Ny/2*L_box,0), length=lines_length, height=Ny*L_box, width=lines_width, color=color.black)

    while(true):
        rate(1)
        distrib = zeros((Nx,Ny),dtype = int)
        distrib = get_data()
        for i in range(Nx):
            for j in range(Ny):
                if(distrib[i][j] == 0):
                    disk[i][j].opacity = 0
                elif(distrib[i][j] == 1):
                    disk[i][j].opacity = 1.
                    disk[i][j].color = color.white
                elif(distrib[i][j] == -1):
                    disk[i][j].opacity = 1.
                    disk[i][j].color=color.black

if __name__ == '__main__':
    game()
