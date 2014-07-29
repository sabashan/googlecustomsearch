package org.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.training.model.Event;
import org.training.util.DBConnection;

public class EventDAO {

	/* To list all events */
	public List<Event> findAll() {
		List<Event> list = new ArrayList<Event>();
		Connection c = null;

		String sql = "SELECT e.id_event, e.date, e.time, g.group_name, l.location,t.topic,t.trainer FROM topic as t, location as l, groups as g, event as e WHERE e.id_topic=t.id_topic AND e.id_location=l.id_location AND e.id_group=g.id_group";

		try {
			c = DBConnection.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processSummaryRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return list;
	}

	/* To list out events search by date */
	public List<Event> findByDate(String date) {

		String sql = "SELECT e.id_event, e.date, e.time, g.group_name, l.location,t.topic,t.trainer FROM topic as t, location as l, groups as g, event as e WHERE e.id_topic=t.id_topic AND e.id_location=l.id_location AND e.id_group=g.id_group AND date=?";

		List<Event> list = new ArrayList<Event>();
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return list;
	}

	/* To list out events search by id */
		public List<Event> findById(int id) {

		String sql = "SELECT e.id_event, e.date, e.time, g.group_name, l.location,t.topic,t.trainer FROM topic as t, location as l, groups as g, event as e WHERE e.id_topic=t.id_topic AND e.id_location=l.id_location AND e.id_group=g.id_group AND id_event=?";
		
		List<Event> list = new ArrayList<Event>();
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			//ps.setInt(1, id);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return list;
	}

	/* To list out events search by groups */
	public List<Event> findByGroup(String group) {

		String sql = "SELECT e.id_event, e.date, e.time, g.group_name, l.location,t.topic,t.trainer FROM topic as t, location as l, groups as g, event as e WHERE e.id_topic=t.id_topic AND e.id_location=l.id_location AND e.id_group=g.id_group AND e.id_group=(SELECT id_group FROM groups WHERE group_name=?)";
		List<Event> list = new ArrayList<Event>();
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, group);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return list;
	}

	/* To list out events search by topics */
	public List<Event> findByTopic(String topic) {

		String sql = "SELECT e.id_event, e.date, e.time, g.group_name, l.location,t.topic,t.trainer FROM topic as t, location as l, groups as g, event as e WHERE e.id_topic=t.id_topic AND e.id_location=l.id_location AND e.id_group=g.id_group AND e.id_topic=(SELECT id_topic FROM topic WHERE topic=?)";
		List<Event> list = new ArrayList<Event>();
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, topic);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return list;
	}

	/* To list out events search by location */
	public List<Event> findByLocation(String location) {

		String sql = "SELECT e.id_event, e.date, e.time, g.group_name, l.location,t.topic,t.trainer FROM topic as t, location as l, groups as g, event as e WHERE e.id_topic=t.id_topic AND e.id_location=l.id_location AND e.id_group=g.id_group AND e.id_location=(SELECT id_location FROM location WHERE location=?)";
		List<Event> list = new ArrayList<Event>();
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, location);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return list;
	}

	/* To list out events search by email */
	public List<Event> eventFindByEmail(String email) {
		
		String sql = "SELECT e.id_event, e.date, e.time, g.group_name, l.location,t.topic,t.trainer FROM topic as t, location as l, groups as g, event as e WHERE e.id_topic=t.id_topic AND e.id_location=l.id_location AND e.id_group=g.id_group AND e.id_group=(SELECT id_group FROM users WHERE email=?)";
		List<Event> list = new ArrayList<Event>();
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}		
		return list;
	}

	/* To create a new event */
	public Event create(Event event) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = DBConnection.getConnection();

			ps = c.prepareStatement(
					"INSERT INTO event (date,time,id_group,id_topic,id_location) VALUES (?,?,(SELECT id_group FROM groups WHERE group_name=?),(SELECT id_topic FROM topic WHERE topic=?),(SELECT id_location FROM location WHERE location=?))",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, event.getDate());
			ps.setString(2, event.getTime());
			ps.setString(3, event.getGroup());
			ps.setString(4, event.getTopic());
			ps.setString(5, event.getLocation());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
		return event;
	}

	public boolean remove(int id) {
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c
					.prepareStatement("DELETE FROM event WHERE id_event=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count == 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBConnection.close(c);
		}
	}

	public Event update(Event event) {
		Connection c = null;
		try {
			c = DBConnection.getConnection();
			PreparedStatement ps = c
					.prepareStatement("UPDATE event SET date=?, time=?, id_group=(SELECT id_group FROM groups WHERE group_name=?), id_topic=(SELECT id_topic FROM topic WHERE topic=?), id_location=(SELECT id_location FROM location WHERE location=?) WHERE id_event=?");
			ps.setString(1, event.getDate());
			ps.setString(2, event.getTime());
			ps.setString(3, event.getGroup());
			ps.setString(4, event.getTopic());
			ps.setString(5, event.getLocation());
			ps.setInt(6, event.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
		}
		return event;
	}

	protected Event processRow(ResultSet rs) throws SQLException {
		Event event = new Event();
		event.setId(rs.getInt("id_event"));
		event.setDate(rs.getString("date"));
		event.setTime(rs.getString("time"));
		event.setGroup(rs.getString("group_name"));
		event.setTopic(rs.getString("topic"));
		event.setTrainer(rs.getString("trainer"));
		event.setLocation(rs.getString("location"));
		return event;
	}

	protected Event processSummaryRow(ResultSet rs) throws SQLException {
		Event event = new Event();
		event.setId(rs.getInt("id_event"));
		event.setDate(rs.getString("date"));
		event.setTime(rs.getString("time"));
		event.setGroup(rs.getString("group_name"));
		event.setTopic(rs.getString("topic"));
		event.setTrainer(rs.getString("trainer"));
		event.setLocation(rs.getString("location"));
		return event;
	}
}